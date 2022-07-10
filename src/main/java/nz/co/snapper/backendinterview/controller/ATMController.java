package nz.co.snapper.backendinterview.controller;

import nz.co.snapper.backendinterview.service.ATMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/atm")
public class ATMController {


    @Autowired
    private ATMService atmService;

    @GetMapping(path = {"/{value}"})
    public int[] getNotes(@PathVariable(name="value") Integer amountToCash) {
        return atmService.getNotes(amountToCash);
    }

}
