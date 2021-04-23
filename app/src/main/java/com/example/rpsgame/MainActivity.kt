package com.example.rpsgame

import android.graphics.drawable.Drawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.example.rpsgame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private enum class option(selectedNumber: Int){
        ROCK(1),
        PAPER(2),
        SCISSORS(3)

    }
    private var mySelection=option.ROCK
    private var computerSelection=option.ROCK


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding= ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.rockButton.setOnClickListener {
            randomize()
            binding.myImageView.setImageDrawable(resources.getDrawable(R.drawable.sheriffrock))
            mySelection=option.ROCK
            compare()
        }
        binding.paperButton.setOnClickListener {
            randomize()
            binding.myImageView.setImageDrawable(resources.getDrawable(R.drawable.sheriffpaper))
            mySelection=option.PAPER
            compare()
        }
        binding.scissorButton.setOnClickListener {
            randomize()
            binding.myImageView.setImageDrawable(resources.getDrawable(R.drawable.sheriffscissors))
            mySelection=option.SCISSORS
            compare()
        }

    }
    private fun compare(): Int{
        if(mySelection==computerSelection){
            binding.textView.text="Draw!"
            return 1

        }
        when(mySelection){
            option.ROCK  -> if(computerSelection == option.PAPER){
                                binding.textView.text="Computer Won!"
                return 1
                            }
            option.PAPER -> if(computerSelection == option.SCISSORS){
                                binding.textView.text="Computer Won!"
                return 1
                            }
            option.SCISSORS -> if(computerSelection == option.ROCK){
                                binding.textView.text="Computer Won!"
                return 1
                            }
        }
        binding.textView.text="You Won!"
        return 1

    }
    //@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun randomize(){
        val randomNumber=(1..3).shuffled().last()
        when(randomNumber){
            1 -> {
                computerSelection=option.ROCK
                binding.computerImageView.setImageDrawable(resources.getDrawable(R.drawable.outlawrock))
            }
            2 -> {
                computerSelection=option.PAPER
                binding.computerImageView.setImageDrawable(resources.getDrawable(R.drawable.outlawpaper))

            }
            3 -> {
                computerSelection=option.SCISSORS
                binding.computerImageView.setImageDrawable(resources.getDrawable(R.drawable.outlawscissors))
            }
        }

    }
}