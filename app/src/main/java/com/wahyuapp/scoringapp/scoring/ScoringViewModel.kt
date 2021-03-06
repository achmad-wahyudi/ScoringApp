package com.wahyuapp.scoringapp.scoring

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class ScoringViewModel : ViewModel() {

    private var _team1Score = MutableLiveData<Int>()
    val team1Score: LiveData<Int>
        get() = _team1Score

    private var _team2Score = MutableLiveData<Int>()
    val team2Score: LiveData<Int>
        get() = _team2Score

    private var _eventFinish = MutableLiveData<Boolean>()
    val eventFinish: LiveData<Boolean>
        get() = _eventFinish

    private var _winner = MutableLiveData<String>()
    val winner: LiveData<String>
        get() = _winner

    private var _teams = MutableLiveData<ArrayList<String>>()
    val teams: LiveData<ArrayList<String>>
        get() = _teams

    val score1String = Transformations.map(team1Score) { score ->
        score.toString()
    }

    val score2String = Transformations.map(team2Score) { score ->
        score.toString()
    }

    init {
        _team1Score.value = 0
        _team2Score.value = 0
        _eventFinish.value = false
        _teams.value = ArrayList()
    }

    fun initTeam(team1: String, team2: String) {
        (_teams.value)?.add(team1)
        (_teams.value)?.add(team2)
    }

    fun updateScore(team: Int) {
        if (team == 1) {
            _team1Score.value = (_team1Score.value)?.plus(1)
            _winner.value = (_teams.value)?.get(0)
        } else {
            _team2Score.value = (_team2Score.value)?.plus(1)
            _winner.value = (_teams.value)?.get(1)
        }

        if ((_team1Score.value)!! >= 3
            || (_team2Score.value)!! >= 3
        ) {
            _eventFinish.value = true
        }
    }

    fun reset() {
        _team1Score.value = 0
        _team2Score.value = 0
        _eventFinish.value = false
    }
}