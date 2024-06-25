package com.hyphenate.chatdemo.ui.chat

import com.hyphenate.chatdemo.R
import com.hyphenate.easeui.EaseIM
import com.hyphenate.easeui.common.ChatMessage
import com.hyphenate.easeui.common.extensions.showToast
import com.hyphenate.easeui.feature.chat.EaseChatFragment
import com.hyphenate.easeui.feature.chat.activities.EaseChatActivity
import com.hyphenate.easeui.feature.chat.interfaces.OnMessageForwardCallback
import com.hyphenate.easeui.feature.chat.interfaces.OnModifyMessageListener
import com.hyphenate.easeui.feature.chat.interfaces.OnSendCombineMessageCallback

class ChatActivity: EaseChatActivity() {

    override fun setChildSettings(builder: EaseChatFragment.Builder) {
        super.setChildSettings(builder)
        builder.setOnMessageForwardCallback(object : OnMessageForwardCallback {
            override fun onForwardSuccess(message: ChatMessage?) {
                mContext.showToast(R.string.message_forward_success)
            }

            override fun onForwardError(code: Int, errorMsg: String?) {
                mContext.showToast(R.string.message_forward_fail)
            }
        })
        builder.setOnSendCombineMessageCallback(object : OnSendCombineMessageCallback {
            override fun onSendCombineSuccess(message: ChatMessage?) {
                mContext.showToast(R.string.message_forward_success)
            }

            override fun onSendCombineError(message: ChatMessage?, code: Int, errorMsg: String?) {
                mContext.showToast(R.string.message_forward_fail)
            }
        })
        builder.setOnModifyMessageListener(object : OnModifyMessageListener{
            override fun onModifyMessageSuccess(messageModified: ChatMessage?) {

            }

            override fun onModifyMessageFailure(messageId: String?, code: Int, error: String?) {
                mContext.showToast(R.string.message_modify_fail)
            }
        })
        builder.turnOnTypingMonitor(EaseIM.getConfig()?.chatConfig?.enableChatTyping?:true)
        builder.setCustomFragment(ChatFragment())
            .setCustomAdapter(CustomMessagesAdapter())
    }
}