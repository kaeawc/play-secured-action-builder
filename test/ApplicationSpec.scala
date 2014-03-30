package controllers

import play.api.test._
import play.api.test.Helpers._

class ApplicationSpec extends org.specs2.mutable.Specification {

    "GET /normal" should {

        "respond with OK" in new WithApplication() {

            val request = FakeRequest("GET", "/normal")

            val response = route(request)

            response must beSome

            status(response.get) mustEqual OK
        }
    }

    "GET /secured" should {

        "respond with Unauthorized" in new WithApplication() {

            val request = FakeRequest("GET", "/secured")

            val response = route(request)

            response must beSome

            status(response.get) mustEqual 403
        }
    }

    "GET /async" should {

        "respond with OK" in new WithApplication() {

            val request = FakeRequest("GET", "/async")

            val response = route(request)

            response must beSome

            status(response.get) mustEqual OK
        }
    }

    "GET /secured/async" should {

        "respond with Unauthorized" in new WithApplication() {

            val request = FakeRequest("GET", "/secured/async")

            val response = route(request)

            response must beSome

            status(response.get) mustEqual 403
        }
    }
}