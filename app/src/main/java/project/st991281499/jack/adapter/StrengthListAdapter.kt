package project.st991281499.jack.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import project.st991281499.jack.R
import project.st991281499.jack.data.Strength
import project.st991281499.jack.databinding.StrengthCardBinding

class StrengthListAdapter(var strengthList: List<Strength>, private val onStrengthClicked: (Strength) -> Unit) : RecyclerView.Adapter<StrengthListAdapter.StrengthViewHolder>(){



    override fun getItemCount(): Int {
        return strengthList.size
    }

    fun setData(strengthList: List<Strength>){
        this.strengthList = strengthList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StrengthViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.strength_card, parent, false)
        val binding = StrengthCardBinding.bind(view)
        return StrengthViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StrengthViewHolder, position: Int) {
        val currentExercise = strengthList[position]
        holder.itemView.setOnClickListener{
            onStrengthClicked(currentExercise)
        }
        holder.bind(currentExercise)
    }

    class StrengthViewHolder(private var binding: StrengthCardBinding):
        RecyclerView.ViewHolder(binding.root){
                fun bind(strength: Strength) {
                    binding.apply{
                        setsTv.text = strength.sets
                        repsTv.text = strength.reps
                        dateTv.text = strength.datetime.substring(0, 10)
                        timeTv.text = strength.datetime.substring(11, 16)

                    }
            }
        }


}
