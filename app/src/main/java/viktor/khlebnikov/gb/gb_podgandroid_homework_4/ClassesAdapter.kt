package viktor.khlebnikov.gb.gb_podgandroid_homework_4

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import viktor.khlebnikov.gb.gb_podgandroid_homework_4.databinding.HomeworkCardBinding
import viktor.khlebnikov.gb.gb_podgandroid_homework_4.domain.Lesson

class ClassesAdapter(context: Context) :
    RecyclerView.Adapter<ClassesAdapter.LessonVH>() {

    var lessons = mutableListOf<Lesson>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    private val inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = LessonVH(
        HomeworkCardBinding.inflate(inflater, parent, false))

    override fun onBindViewHolder(holder: LessonVH, position: Int) {
        holder.bind(lessons[position])
    }

    override fun getItemCount() = lessons.size

    class LessonVH(private val binding: HomeworkCardBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(lesson: Lesson) {
            with(binding.lessonCard) {
                lessonName.text = lesson.name
            }
        }
    }

}