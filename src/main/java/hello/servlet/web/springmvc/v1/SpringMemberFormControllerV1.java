package hello.servlet.web.springmvc.v1;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//@Controller // 아래 두 작업을 동시에 해줌
@Component //스프링 빈으로 등록
@RequestMapping //RequestMappingHandlerMapping이 이 빈을 핸들러로 인식해서 꺼낼 수 있음
public class SpringMemberFormControllerV1 {

    @RequestMapping("/springmvc/v1/members/new-form")
    public ModelAndView process() {
        return new ModelAndView("new-form");
    }
}
