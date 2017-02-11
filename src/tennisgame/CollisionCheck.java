package tennisgame;

import tennisgame.Game.State;

interface CollisionCheck {
   State checkCollisionWith(Ball ball);
}
