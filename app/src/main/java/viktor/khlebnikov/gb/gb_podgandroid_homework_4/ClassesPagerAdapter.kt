package viktor.khlebnikov.gb.gb_podgandroid_homework_4

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import androidx.recyclerview.widget.RecyclerView
import viktor.khlebnikov.gb.gb_podgandroid_homework_4.databinding.LessonCardBinding
import viktor.khlebnikov.gb.gb_podgandroid_homework_4.domain.Lesson

class ClassesPagerAdapter(context: Context) :
    RecyclerView.Adapter<ClassesPagerAdapter.LessonVH>() {

    var lessons = mutableListOf<Lesson>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    private val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        LessonVH(
            LessonCardBinding.inflate(layoutInflater, parent, false).apply {
                root.layoutParams = (root.layoutParams as ViewGroup.MarginLayoutParams).apply {
                    height = MATCH_PARENT
                }
            }
        )

    override fun onBindViewHolder(holder: LessonVH, position: Int) {
        holder.bind(lessons[position])
    }

    override fun getItemCount() = lessons.size

    class LessonVH(private val binding: LessonCardBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(lesson: Lesson) {
            with(binding) {
                lessonName.text = lesson.name
            }
        }
    }

}

