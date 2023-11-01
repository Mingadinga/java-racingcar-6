package racingcar.racingGame.gameFlow.controller;

import racingcar.participant.controller.ParticipantController;
import racingcar.racingGame.gameFlow.domain.Range;
import racingcar.racingGame.gameFlow.domain.RangedNumber;
import racingcar.racingGame.gameFlow.service.GameFlowManager;
import racingcar.racingGame.gameFlow.service.GameFlowManagerByCount;
import racingcar.racingGame.move.MoveManager;
import racingcar.view.InputComponent;
import racingcar.view.OutputComponent;

public class GameFlowControllerImpl implements GameFlowController {

    private final OutputComponent outputComponent;
    private final InputComponent inputComponent;
    private final MoveManager moveManager;
    private final ParticipantController participantController;
    private GameFlowManager gameFlowManager;
    private Range range = new Range(1, 10);

    public GameFlowControllerImpl(OutputComponent outputComponent, InputComponent inputComponent,
                                  MoveManager moveManager, ParticipantController participantController) {
        this.outputComponent = outputComponent;
        this.inputComponent = inputComponent;
        this.moveManager = moveManager;
        this.participantController = participantController;
    }

    @Override
    public void initializeSettings() {
        RangedNumber gameCount = interactWithViewAndGetInput();
        this.gameFlowManager = new GameFlowManagerByCount(gameCount, this.moveManager);
    }

    private RangedNumber interactWithViewAndGetInput() {
        outputComponent.print();
        String number = inputComponent.input();
        return range.of(Integer.parseInt(number));
    }

    @Override
    public void start() {
        if (gameFlowManager.isContinuable()) {
            gameFlowManager.doContinue();
        }
    }

}
