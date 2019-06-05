package lk.ijse.dep.movie.main;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("lk.ijse.dep.movie")
@Import(JpaConfig.class)
public class AppConfig {
}
