package io.github.lordraydenmk.android_fx.example05

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import arrow.fx.typeclasses.seconds
import io.github.lordraydenmk.android_fx.R
import io.github.lordraydenmk.android_fx.view.render
import kotlinx.android.synthetic.main.layout_lce.*

class RequestWithTimeoutActivity : AppCompatActivity() {

    private val viewModel by viewModels<RequestWithTimeoutViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_request_with_timeout)

        var timeout = 1.seconds
        textError.setOnClickListener {
            timeout += 1.seconds
            viewModel.execute(timeout)
        }

        viewModel.viewState.observe(this, Observer(this::render))
    }
}
