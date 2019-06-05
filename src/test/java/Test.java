import lk.ijse.dep.movie.dao.ActorDAO;
import lk.ijse.dep.movie.entity.Actor;
import lk.ijse.dep.movie.main.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();
        ctx.registerShutdownHook();
        ActorDAO bean = ctx.getBean(ActorDAO.class);
        System.out.println(bean.getTopActorByOrderByIdDesc().getId());
    }
}
