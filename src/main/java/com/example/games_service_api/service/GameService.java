package com.example.games_service_api.service;

import com.example.games_service_api.commons.entities.GameModel;

public interface GameService {
    GameModel createGame(GameModel gameRequest);
    GameModel getGame(long gameId);

    GameModel putGame(GameModel gameRequest);

   GameModel deleteGame(GameModel gameRequest);

}
