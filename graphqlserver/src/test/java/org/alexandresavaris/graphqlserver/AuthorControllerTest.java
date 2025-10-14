package org.alexandresavaris.graphqlserver;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.graphql.test.tester.GraphQlTester;

@GraphQlTest(AuthorController.class)
class AuthorControllerTest {

    @Autowired
    private GraphQlTester graphQlTester;

    @Test
    void shouldGetFirstAuthor() {

        this.graphQlTester
            .documentName("authorDetails")
            .variable("id", "author-1")
            .execute()
            .path("authorById")
            .matchesJson("""
                {
                    "id": "author-1",
                    "firstName": "Joshua",
                    "lastName": "Bloch"
                }
                """);
    }
}
