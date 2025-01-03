package com.example.games_service_api.service.impl;

import com.example.games_service_api.commons.entities.GameModel;
import com.example.games_service_api.repository.GameRepository;
import com.example.games_service_api.service.GameService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;
    public GameServiceImpl(GameRepository gameRepository) {

        this.gameRepository = gameRepository;
    }
    @Override
    public GameModel createGame(GameModel gameRequest) {
        return Optional.of(gameRequest)
                .map(this::mapToEntity)
                .map(gameRepository::save)
                .orElseThrow(()-> new RuntimeException("Error creating game"));
    }
    @Override
    public GameModel getGame(long gameId) {
        return Optional.of(gameId)
                .flatMap(gameRepository::findById)
                .orElseThrow(()->new RuntimeException("Error couldn't find game by id"));
    }

    @Override
    public GameModel putGame(GameModel gameRequest) {
        GameModel existingGame = gameRepository.findById(gameRequest.getGameId())
                .orElseThrow(() -> new RuntimeException("Game not found"));
        existingGame.setName(gameRequest.getName());
        gameRepository.save(existingGame);
        return null;
    }

    @Override
    public GameModel deleteGame(GameModel gameRequest) {
        GameModel existingGame = gameRepository.findById(gameRequest.getGameId())
                .orElseThrow(() -> new RuntimeException("Game not found"));
        gameRepository.delete(existingGame);
        return null;
    }
    private GameModel mapToEntity(GameModel gameRequest) {
        return GameModel.builder()
                .name(gameRequest.getName())
                .build();
    }
}
