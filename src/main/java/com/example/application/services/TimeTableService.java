package com.example.application.services;

import ai.timefold.solver.core.api.score.buildin.hardsoft.HardSoftScore;
import ai.timefold.solver.core.api.solver.SolutionManager;
import ai.timefold.solver.core.api.solver.SolverManager;
import ai.timefold.solver.core.api.solver.SolverStatus;
import com.example.application.domain.timeTable.TimeTable;
import com.example.application.domain.timeTable.TimetableRepository;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import dev.hilla.BrowserCallable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AnonymousAllowed
@BrowserCallable
@RequiredArgsConstructor
public class TimeTableService {
    private final TimetableRepository timetableRepository;
    private final SolverManager<TimeTable,Long> solverManager;
    private final SolutionManager<TimeTable, HardSoftScore> solutionManager;



    public TimeTable findById(Long id) {
        return timetableRepository.findById(id);
    }

    public TimeTable getTimeTable(){

        SolverStatus solverStatus = getSolverStatus();
        TimeTable solution = timetableRepository.findById(TimetableRepository.SINGLETON_TIME_TABLE_ID);
        solution.setSolverStatus(solverStatus);
        return solution;
    }

    private SolverStatus getSolverStatus() {
        return solverManager.getSolverStatus(TimetableRepository.SINGLETON_TIME_TABLE_ID);
    }

    public void solve(){
        solverManager.solveAndListen(TimetableRepository.SINGLETON_TIME_TABLE_ID,
                timetableRepository::findById,
                timetableRepository::save);
    }

    public void stopSolving(){
        solverManager.terminateEarly(TimetableRepository.SINGLETON_TIME_TABLE_ID);
    }


}
