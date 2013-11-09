package com.flagleader.builder.widget.editor.b;

import com.flagleader.builder.widget.editor.s;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.text.FindReplaceDocumentAdapter;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class b extends Dialog
{
  private s a;
  private Button b;
  private Button c;
  private Button d;
  private Button e;
  private FindReplaceDocumentAdapter f;

  public b(s params, Shell paramShell)
  {
    super(paramShell);
    this.a = params;
    this.f = new FindReplaceDocumentAdapter(this.a.m());
    super.setShellStyle(128);
  }

  protected void configureShell(Shell paramShell)
  {
    super.configureShell(paramShell);
    paramShell.setText("查找/替换");
    paramShell.setSize(200, 270);
  }

  protected Control createContents(Composite paramComposite)
  {
    paramComposite.setLayout(new GridLayout(2, false));
    new Label(paramComposite, 16384).setText("查找：");
    Text localText1 = new Text(paramComposite, 2048);
    localText1.setLayoutData(new GridData(768));
    String str = this.a.n().getTextWidget().getSelectionText();
    if ((str != null) && (str.length() > 0))
      localText1.setText(str);
    new Label(paramComposite, 16384).setText("替换为：");
    Text localText2 = new Text(paramComposite, 2048);
    localText2.setLayoutData(new GridData(768));
    Group localGroup = new Group(paramComposite, 0);
    GridData localGridData = new GridData(768);
    localGridData.horizontalSpan = 2;
    localGroup.setLayoutData(localGridData);
    localGroup.setText("方向");
    localGroup.setLayout(new GridLayout(2, true));
    Button localButton1 = new Button(localGroup, 16);
    localButton1.setText("前进");
    Button localButton2 = new Button(localGroup, 16);
    localButton2.setText("后退");
    localGroup = new Group(paramComposite, 0);
    localGridData = new GridData(768);
    localGridData.horizontalSpan = 2;
    localGroup.setLayoutData(localGridData);
    localGroup.setText("选项");
    localGroup.setLayout(new GridLayout(2, true));
    Button localButton3 = new Button(localGroup, 32);
    localButton3.setText("区分大小写");
    Button localButton4 = new Button(localGroup, 32);
    localButton4.setText("整个字");
    Button localButton5 = new Button(localGroup, 32);
    localButton5.setText("正则表达式");
    Composite localComposite = new Composite(paramComposite, 0);
    localGridData = new GridData(768);
    localGridData.horizontalSpan = 2;
    localComposite.setLayoutData(localGridData);
    localComposite.setLayout(new GridLayout(2, true));
    this.b = new Button(localComposite, 8);
    this.b.setText("查找");
    this.b.setLayoutData(new GridData(768));
    this.c = new Button(localComposite, 8);
    this.c.setText("替换");
    this.c.setLayoutData(new GridData(768));
    this.d = new Button(localComposite, 8);
    this.d.setText("查找/替换");
    this.d.setLayoutData(new GridData(768));
    this.e = new Button(localComposite, 8);
    this.e.setText("关闭窗口");
    this.e.setLayoutData(new GridData(768));
    localButton4.addSelectionListener(new c(this, localButton4, localButton5));
    localButton5.addSelectionListener(new d(this, localButton5, localButton4));
    this.b.addSelectionListener(new e(this, localText1, localButton1, localButton3, localButton4, localButton5));
    this.c.addSelectionListener(new f(this, localText2));
    this.d.addSelectionListener(new g(this, localText2, localText1, localButton1, localButton3, localButton4, localButton5));
    this.e.addSelectionListener(new h(this));
    localButton1.setSelection(true);
    a(false);
    localText1.setFocus();
    return paramComposite;
  }

  private void a(boolean paramBoolean)
  {
    this.c.setEnabled(paramBoolean);
    this.d.setEnabled(paramBoolean);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.editor.b.b
 * JD-Core Version:    0.6.0
 */