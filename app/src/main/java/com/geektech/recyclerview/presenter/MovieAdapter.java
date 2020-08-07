package com.geektech.recyclerview.presenter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geektech.recyclerview.OnItemClickListener;
import com.geektech.recyclerview.R;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.BooksViewHolder> {

    private OnItemClickListener onItemClickListener;

    public void setInBookClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    ArrayList<MovieTask> movieTasks;

    public MovieAdapter(ArrayList<MovieTask> movieTasks) {
        this.movieTasks = movieTasks;
        MovieTask movieTask1 = new MovieTask(R.drawable.play,
                "Игра престолов " +
                        "(сериал 2011 – 2019)",
                "К концу подходит время благоденствия, и лето, длившееся почти десятилетие, угасает. Вокруг средоточия власти Семи королевств, Железного трона, зреет заговор, и в это непростое время король решает искать поддержки у друга юности Эддарда Старка. В мире, где все — от короля до наемника — рвутся к власти, плетут интриги и готовы вонзить нож в спину, есть место и благородству, состраданию и любви. Между тем, никто не замечает пробуждение тьмы из легенд далеко на Севере — и лишь Стена защищает живых к югу от нее.");

        MovieTask movieTask2 = new MovieTask(R.drawable.breaking_bad,
                "Во все тяжкие " +
                        "(сериал 2008 – 2013)",
                "Школьный учитель химии Уолтер Уайт узнаёт, что болен раком лёгких. Учитывая сложное финансовое состояние дел семьи, а также перспективы, Уолтер решает заняться изготовлением метамфетамина. Для этого он привлекает своего бывшего ученика Джесси Пинкмана, когда-то исключённого из школы при активном содействии Уайта. Пинкман сам занимался варкой мета, но накануне, в ходе рейда УБН, он лишился подельника и лаборатории.");

        MovieTask movieTask3 = new MovieTask(R.drawable.friend, "Друзья (сериал 1994 – 2004)",
                "Главные герои - шестеро друзей - Рейчел, Моника, Фиби, Джоуи, Чендлер и Росс. Три девушки и три парня, которые дружат, живут по соседству, вместе убивают время и противостоят жестокой реальности, делятся своими секретами и иногда очень сильно влюбляются.");


        MovieTask movieTask4 = new MovieTask(R.drawable.big,
                "Теория большого взрыва " +
                        "(сериал 2007 – 2019)",
                "Два блестящих физика Леонард и Шелдон - великие умы, которые понимают, как устроена вселенная. Но их гениальность ничуть не помогает им общаться с людьми, особенно с женщинами. Всё начинает меняться, когда напротив них поселяется красавица Пенни.\n" +
                        "\n" +
                        "Стоит также отметить пару странных друзей этих физиков: Воловиц который любит употреблять фразы на разных языках, " +
                        "включая русский, а Раджеш Кутрапали теряет дар речи при виде женщин.");


        MovieTask movieTask5 = new MovieTask(R.drawable.sherlok,
                "Шерлок" +
                        " (сериал 2010 – 2017)",
                "События разворачиваются в наши дни. Он прошел Афганистан, остался инвалидом. По возвращении в родные края встречается с загадочным, но своеобразным гениальным человеком. Тот в поиске соседа по квартире. Лондон, 2010 год. Происходят необъяснимые убийства. Скотланд-Ярд без понятия, за что хвататься. " +
                        "Существует лишь один человек, который в силах разрешить проблемы и найти ответы на сложные вопросы.");


        MovieTask movieTask6 = new MovieTask(R.drawable.su,
                "Сверхъестественное" +
                        " (сериал 2005 – 2020)",
                "Сериал рассказывает о приключениях братьев Сэма и Дина Винчестеров, которые путешествуют по Соединённым Штатам на чёрном автомобиле Chevrolet Impala 1967 года, расследуют паранормальные явления, многие из " +
                        "которых основаны на американских городских легендах и фольклоре, и сражаются с порождениями зла, такими как демоны и призраки..");


        MovieTask movieTask7 = new MovieTask(R.drawable.mol,
                "Настоящий детектив " +
                        "(сериал 2014 – ...)",
                "Первый сезон. В Луизиане в 1995 году происходит странное убийство девушки. В 2012 году дело об убийстве 1995г. повторно открывают, так как произошло похожее убийство. " +
                        "Дабы лучше продвинуться в расследовании, полиция решает допросить бывших детективов, которые работали над делом в 1995г.");


        movieTasks.add(movieTask1);
        movieTasks.add(movieTask2);
        movieTasks.add(movieTask3);
        movieTasks.add(movieTask4);
        movieTasks.add(movieTask5);
        movieTasks.add(movieTask6);
        movieTasks.add(movieTask7);


    }

    @NonNull
    @Override
    public BooksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);
        return new BooksViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BooksViewHolder holder, int position) {
        holder.onBind(movieTasks.get(position));
    }

    @Override
    public int getItemCount() {
        return movieTasks.size();
    }

    public class BooksViewHolder extends RecyclerView.ViewHolder {
        private ImageView img_movie;
        private TextView tv_title;

        public BooksViewHolder(@NonNull View itemView) {
            super(itemView);
            initializationViews(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.OnItemClickListener(getAdapterPosition());

                }
            });
        }

        private void initializationViews(View itemView) {
            img_movie = itemView.findViewById(R.id.img_movie);
            tv_title = itemView.findViewById(R.id.tv_title);

        }

        public void onBind(MovieTask movieTask) {
            img_movie.setImageResource(movieTask.getImg_movie());
            tv_title.setText(movieTask.getTv_title());

        }
    }
}

