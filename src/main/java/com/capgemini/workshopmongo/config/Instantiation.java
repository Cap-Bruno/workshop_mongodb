package com.capgemini.workshopmongo.config;

import com.capgemini.workshopmongo.domain.Post;
import com.capgemini.workshopmongo.domain.User;
import com.capgemini.workshopmongo.dto.AuthorDTO;
import com.capgemini.workshopmongo.repository.PostRepository;
import com.capgemini.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat simpleDF = new SimpleDateFormat("dd/MM/yyyy");
        simpleDF.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, simpleDF.parse("09/02/2024"), "Partiu viajem", "Vou viajar pra caragua.", new AuthorDTO(bob));
        Post post2 = new Post(null, simpleDF.parse("01/03/2024"), "Paraquedismo", "Dia de pular de paraquedas.", new AuthorDTO(alex));

        postRepository.saveAll(Arrays.asList(post1, post2));
    }
}
