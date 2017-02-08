package brain;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pinky.Pinky;

@RestController
@RequestMapping("/")
@CrossOrigin
public class BrainAPI {

    @RequestMapping(method = RequestMethod.POST, value = "register")
    public void register(@RequestBody final Pinky pinky) {

        Controller.getController().register(pinky);

        try {
            Controller.getController().greet(pinky);
        } catch (final Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "sayHello")
    public void sayHello(@RequestParam(value = "greeting") final String greeting) {

        System.out.println(greeting);

    }
}
