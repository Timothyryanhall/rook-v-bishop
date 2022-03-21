package com.grandmasters.rookvbishop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

import java.util.Arrays;

import static com.grandmasters.rookvbishop.Game.*;

@SpringBootApplication
public class RookVBishopApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(RookVBishopApplication.class, args);
    }

    @Override
    public void run(String... args) {
        String commandLineArgs = Arrays.toString(args).replaceAll("[\\[\\](){},]", "");
        switch (commandLineArgs) {
            case ROOK_VS_BISHOP:
                RookVsBishop rvb = new RookVsBishop();
                rvb.playGame();
                break;
            case ROOK_VS_LIBERATED_BISHOP:
                RookVsLiberatedBishop rvlb = new RookVsLiberatedBishop();
                rvlb.playGame();
                break;
            case KNIGHT_VS_BISHOP:
                System.out.println("Still working on implementing two rook mate");
                break;
            default:
                System.out.println(commandLineArgs + " is not yet playable. Please submit a request to enable this gameplay. " +
                        "Thanks!");
        }
    }

}
