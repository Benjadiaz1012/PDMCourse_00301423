package com.pdm0126.rankeduca

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.pdm0126.rankeduca.screens.Options.OptionsScreen
import com.pdm0126.rankeduca.screens.Questions.QuestionsScreen

@Composable
fun MainNavigation() {
    val backStack = rememberNavBackStack(Routes.Questions)

    NavDisplay(
        backStack = backStack,
        onBack = {
            backStack.removeLastOrNull()
        },
        entryProvider = entryProvider {
            entry<Routes.Questions> {
                QuestionsScreen(
                    onQuestionClick = { questionId ->
                        backStack.add(
                            Routes.Options(
                                questionId = questionId
                            )
                        )
                    }
                )
            }

            entry<Routes.Options> { route ->
                OptionsScreen(
                    questionId = route.questionId
                )
            }
        }
    )
}