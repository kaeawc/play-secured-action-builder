package controllers

import play.api.mvc._

import scala.concurrent.{Future,ExecutionContext}
import ExecutionContext.Implicits.global

trait Security {

    class AuthenticatedRequest[A](val username: String, request: Request[A]) extends WrappedRequest[A](request)

    object Secured extends ActionBuilder[AuthenticatedRequest] {
      def invokeBlock[A](request: Request[A], block: (AuthenticatedRequest[A]) => Future[SimpleResult]) = {
        request.session.get("username").map { username =>
          block(new AuthenticatedRequest(username, request))
        } getOrElse {
          Future.successful(Results.Forbidden)
        }
      }
    }
}