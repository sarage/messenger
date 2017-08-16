package com.example.aizhan.messenger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import it.slyce.messaging.SlyceMessagingFragment;
import it.slyce.messaging.listeners.LoadMoreMessagesListener;
import it.slyce.messaging.listeners.OnOptionSelectedListener;
import it.slyce.messaging.message.GeneralOptionsMessage;
import it.slyce.messaging.message.MediaMessage;
import it.slyce.messaging.message.Message;
import it.slyce.messaging.message.MessageSource;
import it.slyce.messaging.message.TextMessage;

public class EnterActivity extends AppCompatActivity {

    private static Message getRandomMessage() {
        Message message;
        if (Math.random() < 0.5) {
            TextMessage textMessage = new TextMessage();
            textMessage.setText("Hello");
            message = textMessage;
        } else {
            MediaMessage mediaMessage = new MediaMessage();
            mediaMessage.setUrl("http://telegram.org.ru/uploads/posts/2017-03/1490220314_4.png");
            message = mediaMessage;
        }
        message.setDate(new Date().getTime());
        if (Math.random() > 0.5) {
            message.setAvatarUrl("https://s-media-cache-ak0.pinimg.com/originals/e2/91/87/e291877d10d05c03a0ab2bdd96e3b7e7.jpg");
            message.setUserId("LP");
            message.setSource(MessageSource.EXTERNAL_USER);
        } else {
            message.setAvatarUrl("http://weburbanist.com/wp-content/uploads/2016/02/animal-art-hammered-468x639.jpg");
            message.setUserId("MP");
            message.setSource(MessageSource.LOCAL_USER);
        }
        return message;
    }

    SlyceMessagingFragment slyceMessagingFragment;

    private boolean hasLoadedMore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);

        getSupportActionBar().setTitle("Сообщения");

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        hasLoadedMore = false;

        slyceMessagingFragment = (SlyceMessagingFragment) getFragmentManager().findFragmentById(R.id.messaging_fragment);
        slyceMessagingFragment.setDefaultAvatarUrl("https://pbs.twimg.com/profile_images/660946436801101824/niM7azZS.jpg");
//      slyceMessagingFragment.setDefaultDisplayName("Matthew Page");
//      slyceMessagingFragment.setDefaultUserId("uhtnaeohnuoenhaeuonthhntouaetnheuontheuo");

        slyceMessagingFragment.setLoadMoreMessagesListener(new LoadMoreMessagesListener() {
            @Override
            public List<Message> loadMoreMessages() {
                if (!hasLoadedMore) {
                    hasLoadedMore = true;
                    ArrayList<Message> messages = new ArrayList<>();
                    GeneralOptionsMessage generalTextMessage = new GeneralOptionsMessage();
                    generalTextMessage.setOptions(new String[]{"", ""});
                    generalTextMessage.setOnOptionSelectedListener(new OnOptionSelectedListener() {
                        @Override
                        public String onOptionSelected(int optionSelected) {
                            return null;
                        }
                    });
                    messages.add(generalTextMessage);
                    for (int i = 0; i < 10; i++)
                        messages.add(getRandomMessage());
                    messages.add(generalTextMessage);
                    return messages;
                }
                else {
                    slyceMessagingFragment.setMoreMessagesExist(false);
                    return new ArrayList<>();
                }
            }
        });

        slyceMessagingFragment.setMoreMessagesExist(true);

        TextMessage textMessage = new TextMessage();
        textMessage.setText("...");
        textMessage.setAvatarUrl("https://image.freepik.com/free-icon/business-person-silhouette-wearing-tie_318-49988.jpg");
        textMessage.setDisplayName("");
        textMessage.setUserId("");
        textMessage.setDate(new Date().getTime());
        textMessage.setSource(MessageSource.EXTERNAL_USER);

        slyceMessagingFragment.addNewMessage(textMessage);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id==android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
