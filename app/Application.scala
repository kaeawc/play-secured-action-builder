package controllers

import play.api.mvc._

import scala.concurrent.{Future,ExecutionContext}
import ExecutionContext.Implicits.global

object Application extends Controller {

/**
 * Normal actions in Play either expect an Action 
 * or a SimpleResult
 */
def normal = Action { Ok("") }

/**
 * Secured, the way you have it implemented, is 
 * expecting an Action
 */
def secured = Action { Ok("") }

/**
 * And Action.async expects a Future of a SimpleResult,
 *  but still returns an Action
 */
def async = Action.async { Future { Ok("") } }

/**
 * What you seem to be looking for is a Secured 
 * that takes a Future[SimpleResult]. To do that you
 * should try to follow the example laid out in the
 * Play documentation for Action Composition.
 */
def securedAsync = Action.async { Future { Ok("") } }

}