package meta.example.supermarket

sealed trait ShufflingPolicy

case object FIFO extends ShufflingPolicy

case object LIFO extends ShufflingPolicy
