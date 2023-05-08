package com.main.servicedashboardmain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@Controller
@EnableScheduling
public class Main {

    private final List<Double> TransactionArray = new ArrayList<>();
    public List<Double> getTransactionArray() {
        return TransactionArray;
    }
    private final List<Double> CustomerArray = new ArrayList<>();
    public List<Double> getCustomerArray(){
        return CustomerArray;
    }
    @GetMapping("/TransactionChart")
    public String TransactionChart(Model model) {
        model.addAttribute("TransactionArray", getTransactionArray());
        return "TransactionChart";
    }
    @GetMapping("/CustomerChart")
    public String CustomerChart(Model model) {
        model.addAttribute("CustomerArray", getCustomerArray());
        return "CustomerChart";
    }

    @GetMapping("/")
    public String home(Model model) {
        List<APIResponse> responses = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();

        // Fetch data from the first URL
        String url1 = "https://my-json-server.typicode.com/NeeleshCfc/Transaction-API/db";
        ResponseEntity<APIResponse> responseEntity1 = restTemplate.getForEntity(URI.create(url1), APIResponse.class);
        APIResponse APIResponse1 = responseEntity1.getBody();
        Double TransactionChart = APIResponse1.getDetails().getMetrics().getHttpServerRequests().getTime();

        // Fetch data from the second URL
        String url2 = "https://my-json-server.typicode.com/NeeleshCfc/Customer-API/db";
        ResponseEntity<APIResponse> responseEntity2 = restTemplate.getForEntity(URI.create(url2), APIResponse.class);
        APIResponse APIResponse2 = responseEntity2.getBody();
        Double CustomerChart = APIResponse2.getDetails().getMetrics().getHttpServerRequests().getTime();

        // Add the new chart data to the arrays
        if (TransactionArray.size() >= 5) {
            TransactionArray.remove(0);
        }
        TransactionArray.add(TransactionChart);

        if (CustomerArray.size() >= 5) {
            CustomerArray.remove(0);
        }
        CustomerArray.add(CustomerChart);
        // list to hold array responses
        model.addAttribute("TransactionArray", TransactionArray);
        model.addAttribute("CustomerArray", CustomerArray);
        model.addAttribute("TransactionChart", TransactionChart);
        model.addAttribute("CustomerChart", CustomerChart);
        // Create a list to hold the TransactionAPIResponse objects
        responses.add(APIResponse1);
        responses.add(APIResponse2);

        // Pass the list and graph data to the Thymeleaf template
        model.addAttribute("responses", responses);

        // Print the arrays
        System.out.println("TransactionArray: " + TransactionArray);
        System.out.println("CustomerArray: " + CustomerArray);

        return "TransactionAPI"; // index.html file name
    }

    @Scheduled(fixedDelay = 5000)
    public void updateCharts() {
        // Create a new instance of ExtendedModelMap
        ExtendedModelMap model = new ExtendedModelMap();

        // Pass the model to the home method
        home(model);
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
