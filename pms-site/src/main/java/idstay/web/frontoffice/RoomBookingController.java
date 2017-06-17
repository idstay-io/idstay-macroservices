package idstay.web.frontoffice;

import idstay.web.frontoffice.support.OtaInvoiceCommand;
import idstay.web.frontoffice.support.RoomRequestCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * Created by min on 5/30/17.
 */

@Controller @Slf4j
@RequestMapping("/frontoffice/booking")
public class RoomBookingController {

    @PostMapping
    String doCommand(@Valid RoomRequestCommand command, BindingResult bindingResult, RedirectAttributes model) {
        System.out.println("doCommand :" + command.toString());

        RoomRequestCommand com = new RoomRequestCommand();
        com.setDeposit(-100);

        model.addFlashAttribute("foo",command);

        return "redirect:/fd/booking/reservationList";
    }


    @GetMapping("/reservationList")
    String dofoo(@ModelAttribute("foo") RoomRequestCommand command, BindingResult bindingResult) {

        System.out.println(command.toString());

        return "fd/reservationList";
    }





}
