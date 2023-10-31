package racingcar.participant.view;

import racingcar.view.ConsoleInputComponent;

public class ParticipantNameInputComponent extends ConsoleInputComponent {

    @Override
    protected void validate(String input) {
        /**
         * token으로 분리해 name validate 필요.
         * Controller에서 주입 받은 Validator가 처리함.
         */

    }
}
