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
    private Disk disk0, disk1, disk2;
    private Tower tower0, tower1, tower2;
    private Disk placeholder = null;
    private boolean shouldSelectSource = true;

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

        this.disk0 = new Disk(2);
        this.disk1 = new Disk(4);
        this.disk2 = new Disk(8);

        this.tower0 = new Tower();
        this.tower1 = new Tower();
        this.tower2 = new Tower();

        this.tower0.push(this.disk2);
        this.tower0.push(this.disk1);
        this.tower0.push(this.disk0);
        this.tower0.display();
    }

    private void selectSource(Tower tower, ViewGroup towerVG)
    {
        if(tower.peek() != null)
        {
            this.placeholder = tower.pop();
            TextView temp = (TextView)towerVG.getChildAt(0);
            towerVG.removeViewAt(0);
            this.placeholderVG.addView(temp);
            this.shouldSelectSource = false;
        }
    }

    private void selectDestination(Tower tower, ViewGroup towerVG)
    {
        if(tower.push(this.placeholder))
        {
            this.placeholder = null;
            TextView temp = (TextView)this.placeholderVG.getChildAt(0);
            this.placeholderVG.removeViewAt(0);
            towerVG.addView(temp, 0);
            this.shouldSelectSource = true;
        }
    }

    public void tower0ButtonPressed(View v)
    {
        if(this.shouldSelectSource)
        {
            this.selectSource(this.tower0, this.tower0VG);
        }
        else
        {
            this.selectDestination(this.tower0, this.tower0VG);
        }
    }

    public void tower1ButtonPressed(View v)
    {
        if(this.shouldSelectSource)
        {
            this.selectSource(this.tower1, this.tower1VG);
        }
        else
        {
            this.selectDestination(this.tower1, this.tower1VG);
        }
    }

    public void tower2ButtonPressed(View v)
    {
        if(this.shouldSelectSource)
        {
            this.selectSource(this.tower2, this.tower2VG);
        }
        else
        {
            this.selectDestination(this.tower2, this.tower2VG);
        }
    }
}
