package com.pokemonshowdown.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by thain on 7/22/14.
*/
public class StatsDialog extends DialogFragment {
    public static final String STAG = "STATS_DIALOG";
    public static final int maxEV = 508;

    private int[] mStats;
    private int[] mEVs;
    private int[] mIVs;

    public StatsDialog() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mStats = getArguments().getIntArray("Stats");
        mEVs = getArguments().getIntArray("EVs");
        mIVs = getArguments().getIntArray("IVs");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        View view = inflater.inflate(R.layout.dialog_stats, container);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setStats(mStats);
        setEVs(mEVs);
        setIVs(mIVs);

        // Below are SeekBars



        // Below are EVs
        EditText editText;

        // Below are IVs
        editText = (EditText) getView().findViewById(R.id.IV_HP);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    private void setStats(int[] stats) {
        setStats(stats[0], stats[1], stats[2], stats[3], stats[4], stats[5]);
    }

    private void setStats(int HP, int Atk, int Def, int Spd, int SpAtk, int SpDef) {
        TextView textView;
        if (HP != -1) {
            mStats[0] = HP;
            textView = (TextView) getView().findViewById(R.id.final_HP);
            textView.setText(Integer.toString(HP), TextView.BufferType.EDITABLE);
        }
        if (Atk != -1) {
            mStats[1] = Atk;
            textView = (TextView) getView().findViewById(R.id.final_Atk);
            textView.setText(Integer.toString(Atk), TextView.BufferType.EDITABLE);
        }
        if (Def != -1) {
            mStats[2] = Def;
            textView = (TextView) getView().findViewById(R.id.final_Def);
            textView.setText(Integer.toString(Def), TextView.BufferType.EDITABLE);
        }
        if (Spd != -1) {
            mStats[3] = Spd;
            textView = (TextView) getView().findViewById(R.id.final_Spd);
            textView.setText(Integer.toString(Spd), TextView.BufferType.EDITABLE);
        }
        if (SpAtk != -1) {
            mStats[4] = SpAtk;
            textView = (TextView) getView().findViewById(R.id.final_SpAtk);
            textView.setText(Integer.toString(SpAtk), TextView.BufferType.EDITABLE);
        }
        if (SpDef != -1) {
            mStats[5] = SpDef;
            textView = (TextView) getView().findViewById(R.id.final_SpDef);
            textView.setText(Integer.toString(SpDef), TextView.BufferType.EDITABLE);
        }
    }

    private int getRemainingEVs() {
        return maxEV - mEVs[0] - mEVs[1] - mEVs[2] - mEVs[3] - mEVs[4] - mEVs[5];
    }

    private void setEVs(int[] EVs) {
        setEVs(EVs[0]==0?-1:EVs[0], EVs[1]==0?-1:EVs[1], EVs[2]==0?-1:EVs[2], EVs[3]==0?-1:EVs[3], EVs[4]==0?-1:EVs[4], EVs[5]==0?-1:EVs[5]);
    }

    private void setEVs(int HP, int Atk, int Def, int Spd, int SpAtk, int SpDef) {
        EditText editText;
        if (HP != -1) {
            mEVs[0] = HP;
            editText = (EditText) getView().findViewById(R.id.EV_HP);
            editText.setText(Integer.toString(HP), TextView.BufferType.EDITABLE);
        }
        if (Atk != -1) {
            mEVs[1] = Atk;
            editText = (EditText) getView().findViewById(R.id.EV_Atk);
            editText.setText(Integer.toString(Atk), TextView.BufferType.EDITABLE);
        }
        if (Def != -1) {
            mEVs[2] = Def;
            editText = (EditText) getView().findViewById(R.id.EV_Def);
            editText.setText(Integer.toString(Def), TextView.BufferType.EDITABLE);
        }
        if (Spd != -1) {
            mEVs[3] = Spd;
            editText = (EditText) getView().findViewById(R.id.EV_Spd);
            editText.setText(Integer.toString(Spd), TextView.BufferType.EDITABLE);
        }
        if (SpAtk != -1) {
            mEVs[4] = SpAtk;
            editText = (EditText) getView().findViewById(R.id.EV_SpAtk);
            editText.setText(Integer.toString(SpAtk), TextView.BufferType.EDITABLE);
        }
        if (SpDef != -1) {
            mEVs[5] = SpDef;
            editText = (EditText) getView().findViewById(R.id.EV_SpDef);
            editText.setText(Integer.toString(SpDef), TextView.BufferType.EDITABLE);
        }
        editText = (EditText) getView().findViewById(R.id.EV_HP);
        int remainingEVs = getRemainingEVs();
        if (editText.getText().toString().matches("")) {
            editText.setHint(Integer.toString(remainingEVs));
        }
        editText = (EditText) getView().findViewById(R.id.EV_Atk);
        if (editText.getText().toString().matches("")) {
            editText.setHint(Integer.toString(remainingEVs));
        }
        editText = (EditText) getView().findViewById(R.id.EV_Def);
        if (editText.getText().toString().matches("")) {
            editText.setHint(Integer.toString(remainingEVs));
        }
        editText = (EditText) getView().findViewById(R.id.EV_Spd);
        if (editText.getText().toString().matches("")) {
            editText.setHint(Integer.toString(remainingEVs));
        }
        editText = (EditText) getView().findViewById(R.id.EV_SpAtk);
        if (editText.getText().toString().matches("")) {
            editText.setHint(Integer.toString(remainingEVs));
        }
        editText = (EditText) getView().findViewById(R.id.EV_SpDef);
        if (editText.getText().toString().matches("")) {
            editText.setHint(Integer.toString(remainingEVs));
        }
    }

    private void setIVs(int[] IVs) {
        setIVs(IVs[0], IVs[1], IVs[2], IVs[3], IVs[4], IVs[5]);
    }

    private void setIVs(int HP, int Atk, int Def, int Spd, int SpAtk, int SpDef) {
        EditText editText;
        if (HP != -1) {
            mIVs[0] = HP;
            editText = (EditText) getView().findViewById(R.id.IV_HP);
            editText.setText(Integer.toString(HP), TextView.BufferType.EDITABLE);
        }
        if (Atk != -1) {
            mIVs[1] = Atk;
            editText = (EditText) getView().findViewById(R.id.IV_Atk);
            editText.setText(Integer.toString(Atk), TextView.BufferType.EDITABLE);
        }
        if (Def != -1) {
            mIVs[2] = Def;
            editText = (EditText) getView().findViewById(R.id.IV_Def);
            editText.setText(Integer.toString(Def), TextView.BufferType.EDITABLE);
        }
        if (Spd != -1) {
            mIVs[3] = Spd;
            editText = (EditText) getView().findViewById(R.id.IV_Spd);
            editText.setText(Integer.toString(Spd), TextView.BufferType.EDITABLE);
        }
        if (SpAtk != -1) {
            mIVs[4] = SpAtk;
            editText = (EditText) getView().findViewById(R.id.IV_SpAtk);
            editText.setText(Integer.toString(SpAtk), TextView.BufferType.EDITABLE);
        }
        if (SpDef != -1) {
            mIVs[5] = SpDef;
            editText = (EditText) getView().findViewById(R.id.IV_SpDef);
            editText.setText(Integer.toString(SpDef), TextView.BufferType.EDITABLE);
        }
    }
}