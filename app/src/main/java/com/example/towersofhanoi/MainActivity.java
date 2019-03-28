package com.example.towersofhanoi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private TextView disk0TV, disk1TV, disk2TV;
    private ViewGroup tower0VG, tower1VG, tower2VG, placeholderVG;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.disk0TV = this.findViewById(R.id.disk0);
        this.disk1TV = this.findViewById(R.id.disk1);
        this.disk2TV = this.findViewById(R.id.disk2);

        this.placeholderVG = this.findViewById(R.id.placeHolderVG);
        this.tower0VG = this.findViewById(R.id.tower0VG);
        this.tower1VG = this.findViewById(R.id.tower1VG);
        this.tower2VG = this.findViewById(R.id.tower2VG);

        Stack s = new Stack();
        s.push(2);
        s.push(3);
        s.push(7);
        s.push(5);
        s.display();
        s.pop();
        s.pop();
        s.pop();
        s.display();
        System.out.println("*** " + s.peek());

    }

    public void tower0ButtonPressed(View v)
    {
        View temp = this.tower0VG.getChildAt(0);
        this.tower0VG.removeViewAt(0);
        this.placeholderVG.addView(temp);
    }

    public void tower1ButtonPressed(View v)
    {
        View temp = this.placeholderVG.getChildAt(0);
        this.placeholderVG.removeViewAt(0);
        this.tower1VG.addView(temp, 0);
    }
}
