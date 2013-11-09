package com.flagleader.builder.dialogs.b;

import com.flagleader.builder.dialogs.r;
import com.flagleader.repository.db.TableFunction;
import com.flagleader.repository.lang.h;
import com.flagleader.repository.rom.MethodParam;
import java.util.List;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class m extends r
{
  private TableFunction a = null;
  private String b;
  private String c;
  private String d;
  private Text e;
  private Text f;
  private Combo g;

  public m(Shell paramShell, TableFunction paramTableFunction)
  {
    super(paramShell);
    this.a = paramTableFunction;
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    setMessage(a("title.AddWhereDialog"));
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    Composite localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setLayout(a(2));
    localComposite2.setLayoutData(a(400, 100));
    a(localComposite2).setText(a("disname.AddWhereDialog") + ":  ");
    this.f = a(localComposite2, 2048, 380, 12);
    if (this.a != null)
      this.f.setText(this.a.getDisplayName());
    else
      this.f.setText("addWhere{arg1}");
    a(localComposite2).setText(a("wheresql.AddWhereDialog") + ":  ");
    this.e = a(localComposite2, 2048, 380, 12);
    if (this.a != null)
      this.e.setText(this.a.getValueName().substring(15, this.a.getValueName().length() - 1));
    else
      this.e.setText("field = ? ");
    a(localComposite2, a("selecttype.AddWhereDialog"));
    this.g = b(localComposite2, 12, 190, 18);
    this.g.setItems(com.flagleader.repository.m.a().g().c());
    if (this.g.getItemCount() < 20)
      this.g.setVisibleItemCount(this.g.getItemCount());
    else
      this.g.setVisibleItemCount(20);
    if (this.a != null)
      this.g.setText(((MethodParam)this.a.getParams().get(0)).getTypeName());
    this.e.selectAll();
    this.e.forceFocus();
    return localComposite1;
  }

  protected void okPressed()
  {
    this.b = this.e.getText();
    this.c = this.g.getText();
    this.d = this.f.getText();
    super.okPressed();
  }

  public String a()
  {
    return this.b;
  }

  public String b()
  {
    return this.c;
  }

  public String c()
  {
    return this.d;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.b.m
 * JD-Core Version:    0.6.0
 */