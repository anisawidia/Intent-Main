package com.chirikualii.pertemuan3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.chirikualii.pertemuan3.databinding.ActivityMatchBinding

class MatchActivity : AppCompatActivity() {

    lateinit var binding: ActivityMatchBinding

    var scoreA = 0
    var scoreB = 0

    //
    var teamA =""
    var teamB =""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMatchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        teamA = intent.getStringExtra("timA").toString()
        teamB = intent.getStringExtra("timB").toString()

        binding.tvTeamA.text = teamA

        binding.tvTeamB.text = teamB

        binding.btnTeamAPlus.setOnClickListener { addScoreA() }

        binding.btnTeamAMinus.setOnClickListener { minusScoreA() }

        binding.btnTeamBPlus.setOnClickListener { addScoreB() }

        binding.btnTeamBMinus.setOnClickListener { minusScoreB() }

        binding.btnReset.setOnClickListener { resetScore() }

        binding.btnDone.setOnClickListener {

            //kirim data
        // team a, team b, score a, scrore b ke result activity

            teamA = binding.tvTeamA.text.toString()
            teamB = binding.tvTeamB.text.toString()

            val intent = Intent(this,ResultActivity::class.java)
            intent.putExtra("resultA", teamA+" : "+scoreA)
            intent.putExtra("resultB", teamB+" : "+scoreB)
            startActivity(intent)

        }

    }


    private fun addScoreA() {
        scoreA += 1
        binding.tvTeamAScore.text = scoreA.toString()
    }

    private fun minusScoreA() {
        if (scoreA > 0){
            scoreA -= 1
            binding.tvTeamAScore.text = scoreA.toString()
        }
    }

    private fun addScoreB() {
        scoreB += 1
        binding.tvTeamBScore.text = scoreB.toString()
    }

    private fun minusScoreB() {
        if (scoreB > 0){
            scoreB -= 1
            binding.tvTeamBScore.text = scoreB.toString()
        }
    }

    private fun resetScore() {
        scoreB = 0
        scoreA = 0

        binding.tvTeamAScore.text = scoreA.toString()
        binding.tvTeamBScore.text = scoreB.toString()
    }
}