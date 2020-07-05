package meta.example.supermarket

import meta.deep.runtime.Actor
import meta.example.supermarket.people.MealPlan
import squid.quasi.lift

@lift
class Ad(var subject: MealPlan) extends Actor {



}
