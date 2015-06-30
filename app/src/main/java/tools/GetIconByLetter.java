package tools;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;

import turingmachine.com.sharetime20.R;

/**
 * Created by gaoyang on 15/6/30.
 */
public class GetIconByLetter {

    public Drawable getIcon(View view,String sortLetter){
            if(sortLetter==null){
                return view.getResources().getDrawable(R.drawable.s);
            }

           switch(sortLetter){
               case "A":
                   return view.getResources().getDrawable(R.drawable.a);
               case "B":
                   return view.getResources().getDrawable(R.drawable.b);

               case "C":
                   return view.getResources().getDrawable(R.drawable.c);

               case "D":
                   return view.getResources().getDrawable(R.drawable.d);

               case "E":
                   return view.getResources().getDrawable(R.drawable.e);

               case "F":
                   return view.getResources().getDrawable(R.drawable.f);

               case "G":
                   return view.getResources().getDrawable(R.drawable.g);

               case "H":
                   return view.getResources().getDrawable(R.drawable.h);

               case "I":
                   return view.getResources().getDrawable(R.drawable.i);

               case "J":
                   return view.getResources().getDrawable(R.drawable.j);

               case "K":
                   return view.getResources().getDrawable(R.drawable.k);

               case "L":
                   return view.getResources().getDrawable(R.drawable.l);

               case "M":
                   return view.getResources().getDrawable(R.drawable.m);

               case "N":
                   return view.getResources().getDrawable(R.drawable.n);

               case "O":
                   return view.getResources().getDrawable(R.drawable.o);

               case "P":
                   return view.getResources().getDrawable(R.drawable.p);

               case "Q":
                   return view.getResources().getDrawable(R.drawable.q);

               case "R":
                   return view.getResources().getDrawable(R.drawable.r);

               case "S":
                   return view.getResources().getDrawable(R.drawable.s);

               case "T":
                   return view.getResources().getDrawable(R.drawable.t);

               case "U":
                   return view.getResources().getDrawable(R.drawable.u);

               case "V":
                   return view.getResources().getDrawable(R.drawable.v);

               case "W":
                   return view.getResources().getDrawable(R.drawable.w);

               case "X":
                   return view.getResources().getDrawable(R.drawable.x);

               case "Y":
                   return view.getResources().getDrawable(R.drawable.y);

               case "Z":
                   return view.getResources().getDrawable(R.drawable.z);
               default:
                   return view.getResources().getDrawable(R.drawable.s);

           }
    }

    public Drawable getIcon(Context view,String sortLetter){
        if(sortLetter==null){
            return view.getResources().getDrawable(R.drawable.s);
        }

        switch(sortLetter){
            case "A":
                return view.getResources().getDrawable(R.drawable.a);
            case "B":
                return view.getResources().getDrawable(R.drawable.b);

            case "C":
                return view.getResources().getDrawable(R.drawable.c);

            case "D":
                return view.getResources().getDrawable(R.drawable.d);

            case "E":
                return view.getResources().getDrawable(R.drawable.e);

            case "F":
                return view.getResources().getDrawable(R.drawable.f);

            case "G":
                return view.getResources().getDrawable(R.drawable.g);

            case "H":
                return view.getResources().getDrawable(R.drawable.h);

            case "I":
                return view.getResources().getDrawable(R.drawable.i);

            case "J":
                return view.getResources().getDrawable(R.drawable.j);

            case "K":
                return view.getResources().getDrawable(R.drawable.k);

            case "L":
                return view.getResources().getDrawable(R.drawable.l);

            case "M":
                return view.getResources().getDrawable(R.drawable.m);

            case "N":
                return view.getResources().getDrawable(R.drawable.n);

            case "O":
                return view.getResources().getDrawable(R.drawable.o);

            case "P":
                return view.getResources().getDrawable(R.drawable.p);

            case "Q":
                return view.getResources().getDrawable(R.drawable.q);

            case "R":
                return view.getResources().getDrawable(R.drawable.r);

            case "S":
                return view.getResources().getDrawable(R.drawable.s);

            case "T":
                return view.getResources().getDrawable(R.drawable.t);

            case "U":
                return view.getResources().getDrawable(R.drawable.u);

            case "V":
                return view.getResources().getDrawable(R.drawable.v);

            case "W":
                return view.getResources().getDrawable(R.drawable.w);

            case "X":
                return view.getResources().getDrawable(R.drawable.x);

            case "Y":
                return view.getResources().getDrawable(R.drawable.y);

            case "Z":
                return view.getResources().getDrawable(R.drawable.z);
            default:
                return view.getResources().getDrawable(R.drawable.s);
        }
    }
}
