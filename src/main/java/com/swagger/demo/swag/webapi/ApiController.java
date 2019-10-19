package com.swagger.demo.swag.webapi;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
public class ApiController {
	 
	@ApiOperation(value = "View a list of available apartments")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the list of apartments")
    })
	@RequestMapping(value = "/getListApi", method = RequestMethod.GET)
	public ResponseEntity custom() {
		
	    return new ResponseEntity("hey list api", HttpStatus.OK);
	}
	
	@ApiOperation(value = "View a the specified apartment")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the apartment")
    })
	@GetMapping("/getOneApi")
    public ResponseEntity timeConsumingAPI(@RequestParam(value = "delay", defaultValue = "0") Integer delay) throws InterruptedException {
        if(delay == 0) {
            Random random = new Random();
            delay = random.nextInt(10);
        }

        TimeUnit.SECONDS.sleep(delay);
        return new ResponseEntity("Result", HttpStatus.OK);
    }
}
