package project.st991281499.jack.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import project.st991281499.jack.R
import project.st991281499.jack.data.Cardio
import project.st991281499.jack.databinding.CardioCardBinding

class CardioListAdapter(var cardioList: List<Cardio>, private val onCardioClicked: (Cardio) -> Unit) : RecyclerView.Adapter<CardioListAdapter.CardioViewHolder>(){



    override fun getItemCount(): Int {
        return cardioList.size
    }

    fun setData(cardioList: List<Cardio>){
        this.cardioList = cardioList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardioViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cardio_card, parent, false)
        val binding = CardioCardBinding.bind(view)
        return CardioViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardioViewHolder, position: Int) {
        val currentExercise = cardioList[position]
        holder.itemView.setOnClickListener{
            onCardioClicked(currentExercise)
        }
        holder.bind(currentExercise)
    }

    class CardioViewHolder(private var binding: CardioCardBinding):
        RecyclerView.ViewHolder(binding.root){
                fun bind(cardio: Cardio) {
                    binding.apply{
                        durationTv.text = cardio.duration
                        dateTv.text = cardio.datetime.substring(0, 10)
                        timeTv.text = cardio.datetime.substring(11, 16)

                    }
            }
        }


}
