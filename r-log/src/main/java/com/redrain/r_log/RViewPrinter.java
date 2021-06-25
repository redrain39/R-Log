package com.redrain.r_log;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RViewPrinter implements RLogPrinter {

    private RecyclerView recyclerView;
    private LogAdapter logAdapter;
    private RViewPrinterProvider viewPrinterProvider;

    public RViewPrinter(Activity activity) {
        FrameLayout rootView = activity.findViewById(android.R.id.content);
        recyclerView = new RecyclerView(activity);
        logAdapter = new LogAdapter(LayoutInflater.from(recyclerView.getContext()));
        LinearLayoutManager layoutManager = new LinearLayoutManager(recyclerView.getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(logAdapter);
        viewPrinterProvider = new RViewPrinterProvider(rootView, recyclerView);
    }

    @NonNull
    public RViewPrinterProvider getViewPrinterProvider() {
        return viewPrinterProvider;
    }

    @Override
    public void print(@NonNull RLogConfig config, int level, String tag, @NonNull String printString) {
        logAdapter.addRLogMo(new RLogMo(System.currentTimeMillis(), level, tag, printString));
        recyclerView.smoothScrollToPosition(logAdapter.getItemCount() - 1);
    }

    private static class LogAdapter extends RecyclerView.Adapter<LogViewHolder> {

        private LayoutInflater inflater;
        private List<RLogMo> logs = new ArrayList<>();

        public LogAdapter(LayoutInflater inflater) {
            this.inflater = inflater;
        }

        void addRLogMo(RLogMo logItem) {
            logs.add(logItem);
            notifyItemInserted(logs.size() - 1);
        }

        @NonNull
        @Override
        public LogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = inflater.inflate(R.layout.item_log, parent, false);
            return new LogViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull RViewPrinter.LogViewHolder holder, int position) {
            RLogMo logItem = logs.get(position);
            int color = getHighLightColor(logItem.level);
            holder.tvTag.setTextColor(color);
            holder.tvMessage.setTextColor(color);

            holder.tvTag.setText(logItem.getFlattened());
            holder.tvMessage.setText(logItem.log);
        }

        private int getHighLightColor(int logLevel) {
            int highLight;
            switch (logLevel) {
                case RLogType.V:
                    highLight = 0xffbbbbbb;
                    break;
                case RLogType.D:
                    highLight = 0xffffffff;
                    break;
                case RLogType.I:
                    highLight = 0xff6a8759;
                    break;
                case RLogType.W:
                    highLight = 0xffbbb529;
                    break;
                case RLogType.E:
                    highLight = 0xffff6b68;
                    break;
                default:
                    highLight = 0xffffff00;
                    break;
            }
            return highLight;
        }

        @Override
        public int getItemCount() {
            return logs.size();
        }
    }

    private static class LogViewHolder extends RecyclerView.ViewHolder {

        TextView tvTag;
        TextView tvMessage;

        public LogViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTag = itemView.findViewById(R.id.tv_tag);
            tvMessage = itemView.findViewById(R.id.tv_message  );
        }
    }
}
