package com.example.games_service_api.service;

import com.example.games_service_api.commons.entities.GameModel;

public interface GameService {
    GameModel createGame(GameModel gameRequest);
    GameModel getGame(long gameId);

    void putGame(Long gameId, GameModel gameRequest);

   void deleteGame(Long gameRequest);

}
