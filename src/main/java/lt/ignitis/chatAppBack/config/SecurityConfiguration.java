//package lt.ignitis.chatAppBack.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.config.ldap.EmbeddedLdapServerContextSourceFactoryBean;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.provisioning.JdbcUserDetailsManager;
//import org.springframework.security.provisioning.UserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//import static org.springframework.security.config.Customizer.withDefaults;
//
//import javax.sql.DataSource;
//
//import lt.ignitis.chatAppBack.services.UserService;
//
//	@Configuration
//	public class SecurityConfiguration {
//
//		@Autowired
//		UserService userService;
//
//	    @Bean
//	    public UserDetailsManager users(DataSource dataSource) {
//	        UserDetails user = User.withDefaultPasswordEncoder()
//	            .username("user")
//	            .password("password")
//	            .roles("USER")
//	            .build();
//	        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
//	        users.createUser(user);
//	        return users;
//	    }
//		
//	    @Bean
//	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//	        http
//	            .cors()
//	            .and()
//				.authorizeRequests()
//					.anyRequest()
//					.authenticated()
//			.and()
//				.httpBasic()
//			.and()
//				.csrf()
//					.disable()
//					.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//	        return http.build();
//	    }
//		
//		@Bean
//		public PasswordEncoder passwordEncoder() {
//			return new BCryptPasswordEncoder();
//		}
//		
//
//	}
