package steps;

import com.jayway.jsonpath.JsonPath;
import controllers.TestController;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.thucydides.core.annotations.Step;
import org.jruby.RubyProcess;
import org.junit.Assert;

import java.net.MalformedURLException;

import static org.junit.Assert.assertThat;

public class MyStepdefs {
    private RequestSpecification requestSpecification;
    private Response response;

    @Step
    public String description(String html) {
        return html;
    }


    @Given("^The user wants to know the list that he has is a board$")
    public void theUserWantsToKnowTheListThatHeHasIsABoard() {
        requestSpecification = RestAssured.given().contentType("application/json")
                .and().queryParams(TestController.getAuthParams());

    }

    @When("^the user sends the petition for get the lists of his board$")
    public void theUserSendsThePetitionForGetTheListsOfHisBoard() throws MalformedURLException {
        response = requestSpecification.when().get(TestController.getlistsInBoards());
    }

    @Then("^the trello api should response only with the list of specific board$")
    public void theTrelloApiShouldResponseOnlyWithTheListOfSpecificBoard() {
        System.out.println("respuesta test trello");
        System.out.println(response.getBody().asString());
    }


    //////CREATE CARD //////
    @Given("^The user want to create card in list TO DO$")
    public void theUserWantToCreateCardInListTODO() {
        System.out.println("entro 1");
        requestSpecification = RestAssured.given().contentType("application/json")
                .and().queryParams(TestController.getAuthParams());
        System.out.println("here 1");
    }

    @When("^the user send request to create the card$")
    public void theUserSendRequestToCreateTheCard() throws MalformedURLException {
        response = requestSpecification.when().post(TestController.postCreateCard());
    }

    @Then("^the card is created in the list TO DO$")
    public void theCardIsCreatedInTheListTODO() {

        String responseBody = response.getBody().asString();
        String name = JsonPath.read(responseBody, "$.name");


        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(name, TestController.nameTODO);


        description("the card called " + name + " was successfully created :) ");
    }
    //pregunta el then hago un get o muestro la respuesta del request

    //ADD MEMBER ///
    @Given("^the user has already created a card$")
    public void theUserHaveAlreadyCreatedACard() {

    }

    @When("^the user add a member in the card$")
    public void theUserAddAMemberInTheCard() {

    }

    @Then("^the member has been added to the card$")
    public void theMemberHasBeenAddedToTheCard() {
    }
}
