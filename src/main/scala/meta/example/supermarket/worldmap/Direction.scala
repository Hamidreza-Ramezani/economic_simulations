package meta.example.supermarket.worldmap

sealed trait Direction

case object Left extends Direction

case object Right extends Direction

case object Down extends Direction

case object Up extends Direction
