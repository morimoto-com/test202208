package base.controller;

import base.constants.ValidationGroup.Button1;
import base.constants.ValidationGroup.Button2;
import base.dto.T001ValidateForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Validator;

@Controller
public class T001ValidateController {

    @Autowired
    private Validator validator;

    /**
     * 初期表示（http://localhost:8080/t001）
     * @param model
     * @param form
     * @return
     */
    @GetMapping("/t001")
    public String init(
            Model model,
            T001ValidateForm form) {
        model.addAttribute("infoMessage", "初期処理完了");
        model.addAttribute(form);
        return "T001Validate";
    }

    /**
     * 入力チェック１ボタン押下処理
     * @param model
     * @param form
     * @param bindingResult
     * @return
     */
    @PostMapping(value="/t001", params="validated1")
    public String validated1(
            Model model,
            // @ModelAttribute・・・入力チェックとは直接関係ありませんが、画面の情報をFormが受け取る
            // ために指定します。
            // @Validated・・・こちらを指定することでPOST時に自動的に入力チェックが実行されます。
            // 入力チェック１を押したときの入力チェックはButton1に限定する
            @ModelAttribute @Validated(Button1.class) T001ValidateForm form,
            // BindingResult・・・入力チェック結果はこの変数に格納されます。必ずForm⇒BindingResult
            // の順で引数を指定してください。
            BindingResult bindingResult) {
        // 入力チェック判定
        if (!bindingResult.hasErrors()){
            model.addAttribute("infoMessage", "エラーなし");
        }
        model.addAttribute(form);
        return "T001Validate";
    }

    /**
     * 入力チェック２ボタン押下処理
     * @param model
     * @param form
     * @param bindingResult
     * @return
     */
    @PostMapping(value="/t001", params="validated2")
    public String validated2(
            Model model,
            // 入力チェック２を押したときの入力チェックはButton2に限定する
            @ModelAttribute @Validated(Button2.class) T001ValidateForm form,
            BindingResult bindingResult) {
        // 入力チェック判定
        if (!bindingResult.hasErrors()){
            model.addAttribute("infoMessage", "エラーなし");
        }
        model.addAttribute(form);
        return "T001Validate";
    }
}