package com.flagleader.builder.dialogs.b;

import com.flagleader.builder.dialogs.r;
import com.flagleader.builder.widget.editor.p;
import com.flagleader.util.TempID;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class h extends r
{
  private String a;
  private String b;
  private Text c;
  private Text d;
  private p e;

  public h(Shell paramShell)
  {
    super(paramShell);
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    setMessage(a("title.AddSheetMapDialog"));
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    Composite localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setLayout(a(2));
    localComposite2.setLayoutData(a(500, 60));
    a(localComposite2).setText(a("disName.SheetTableDialog") + ":  ");
    this.c = a(localComposite2, 2048, 380, 12);
    this.c.setText(a("defaultDisName.AddSheetMapDialog"));
    a(localComposite2).setText(a("varName.SheetTableDialog") + ":  ");
    this.d = a(localComposite2, 2048, 380, 12);
    this.d.setText("map" + TempID.newShortTempID());
    this.c.selectAll();
    this.c.forceFocus();
    return localComposite1;
  }

  protected void okPressed()
  {
    this.a = this.c.getText();
    this.b = this.d.getText();
    super.okPressed();
  }

  public String a()
  {
    return this.a;
  }

  public String b()
  {
    return this.b;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.b.h
 * JD-Core Version:    0.6.0
 */