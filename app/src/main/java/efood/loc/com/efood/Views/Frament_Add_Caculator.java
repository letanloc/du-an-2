package efood.loc.com.efood.Views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import efood.loc.com.efood.R;
import efood.loc.com.efood.Untils.PagerDatePickerDateFormat;
import efood.loc.com.efood.Untils.adapter.DatePagerFragmentAdapter;
import efood.loc.com.efood.Untils.adapter.DefaultDateAdapter;
import efood.loc.com.efood.Untils.model.DateItem;
import efood.loc.com.efood.Untils.view.DateRecyclerView;
import efood.loc.com.efood.Untils.view.RecyclerViewInsetDecoration;

//import efood.loc.com.efood.Model.Unline;
//import efood.loc.com.efood.Untils.unline;

/**
 * Created by loc on 26/02/2016.
 */
//someTextView.setPaintFlags(someTextView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
public class Frament_Add_Caculator extends Fragment {
    View v;
    private ViewPager pager;
    private DateRecyclerView dateList;

    public static Frament_Add_Caculator newInstance() {
        return new Frament_Add_Caculator();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.frament_caculator, container, false);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        pager = (ViewPager) view.findViewById(R.id.pager);
        dateList = (DateRecyclerView) view.findViewById(R.id.date_list);

        dateList.addItemDecoration(new RecyclerViewInsetDecoration(getActivity(), R.dimen.date_card_insets));

        Date start = null;
        Date end = null;
        Date defaultDate = null;

        try {
            start = PagerDatePickerDateFormat.DATE_PICKER_DD_MM_YYYY_FORMAT.parse("02-12-1999");
            end = PagerDatePickerDateFormat.DATE_PICKER_DD_MM_YYYY_FORMAT.parse("02-12-2030");
            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            String DateDefault = format.format(date.getTime());
            defaultDate = PagerDatePickerDateFormat.DATE_PICKER_DD_MM_YYYY_FORMAT.parse(DateDefault);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        dateList.setAdapter(new DefaultDateAdapter(start, end, defaultDate));

        DatePagerFragmentAdapter fragmentAdapter = new DatePagerFragmentAdapter(getFragmentManager(), dateList.getDateAdapter()) {
            @Override
            protected Fragment getFragment(int position, long date) {
                return SimplePageFragment.newInstance(position, date);
            }
        };

        pager.setAdapter(fragmentAdapter);
        dateList.setPager(pager);

        dateList.setDatePickerListener(new DateRecyclerView.DatePickerListener() {
            @Override
            public void onDatePickerItemClick(DateItem dateItem, int position) {
                Toast.makeText(getActivity(), "Clicked: " + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDatePickerPageSelected(int position) {

            }

            @Override
            public void onDatePickerPageStateChanged(int state) {

            }

            @Override
            public void onDatePickerPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
        });

    }

}
