package io.sh4.uj_puma_2021.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView
import io.sh4.uj_puma_2021.*

class RecyclerViewAdapter(private val context: Context, private val imageNames : List<String> = ArrayList(), private val images : List<String> = ArrayList()) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        public val textView: TextView = itemView.findViewById(R.id.image_name)
        public val circleImageView : CircleImageView = itemView.findViewById(R.id.image)
        public val parentLayout : RelativeLayout = itemView.findViewById(R.id.parentLayout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.layout_listitem, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.setText(imageNames.get(position))
        holder.textView.setOnClickListener {
            View.OnClickListener { v ->
                val activity = v!!.context as ShopActivity
                activity.replaceFragment(ProductFragment(), false)
            }
        }
    }

    override fun getItemCount(): Int {
        return imageNames.size
    }
}
