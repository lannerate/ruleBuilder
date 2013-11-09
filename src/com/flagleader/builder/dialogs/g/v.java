package com.flagleader.builder.dialogs.g;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.widget.a.af;
import com.flagleader.manager.a.a.c;
import com.flagleader.manager.a.a.f;
import com.flagleader.util.NumberUtil;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;

public class v extends com.flagleader.builder.dialogs.r
{
  private String b;
  private String c;
  private String d;
  private Button e;
  private Button f;
  private BuilderManager g;
  private int h = 0;
  private Text i;
  private Combo j;
  private StyledText k;
  List a = new ArrayList();

  public v(BuilderManager paramBuilderManager, String paramString1, String paramString2, String paramString3)
  {
    super(paramBuilderManager.getShell());
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
    this.g = paramBuilderManager;
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    setMessage(a("title.ProjVerSelectDialog"));
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    Composite localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setLayout(a(1));
    localComposite2.setLayoutData(a(500, 350));
    Composite localComposite3 = new Composite(localComposite2, 0);
    localComposite3.setLayout(a(3));
    localComposite3.setLayoutData(a(480, 55));
    a(localComposite3, a("projname.ProjVerSelectDialog"));
    this.i = super.a(localComposite3, 2048, 280, 14);
    if (this.b != null)
      this.i.setText(this.b);
    this.i.addFocusListener(new w(this));
    this.f = new Button(localComposite3, 32);
    this.f.setText(a("projectnew.ProjVerSelectDialog"));
    a(localComposite3, a("projver.ProjVerSelectDialog"));
    this.j = super.b(localComposite3, 0, 280, 12);
    if (this.b.length() > 0)
      e();
    for (int m = 0; m < this.a.size(); m++)
    {
      if (!String.valueOf(((List)this.a.get(m)).get(1)).equals(this.c))
        continue;
      this.h = NumberUtil.getInt(((List)this.a.get(m)).get(0));
      this.j.select(m);
      break;
    }
    if (this.h == 0)
      this.j.setText(this.c);
    this.j.addSelectionListener(new x(this));
    this.e = new Button(localComposite3, 32);
    this.e.setText(a("projvernew.ProjVerSelectDialog"));
    a(localComposite2, a("verdesc.ProjVerSelectDialog"));
    Composite localComposite4 = new Composite(localComposite2, 0);
    localComposite4.setLayout(a(1));
    localComposite4.setLayoutData(a(350, 65));
    this.k = new af(this.g, localComposite4, 8389376).m();
    if (this.d != null)
      this.k.setText(this.d);
    return localComposite1;
  }

  private void e()
  {
    try
    {
      if (this.b.length() > 0)
      {
        c localc = this.g.getRulesManager().p();
        this.a = localc.b(this.b);
      }
      else
      {
        this.a.clear();
      }
    }
    catch (Throwable localThrowable)
    {
      this.a.clear();
    }
    this.h = 0;
    String[] arrayOfString = new String[this.a.size()];
    for (int m = 0; m < this.a.size(); m++)
      arrayOfString[m] = String.valueOf(((List)this.a.get(m)).get(1));
    this.j.setItems(arrayOfString);
  }

  protected void okPressed()
  {
    if (!this.c.equals(this.j.getText()))
    {
      this.h = 0;
      this.c = this.j.getText();
    }
    if (((this.h <= 0) && (this.j.getText().length() > 0)) || (this.f.getSelection()))
      try
      {
        f localf = this.g.getRulesManager().t();
        this.h = localf.a(this.i.getText(), this.j.getText(), this.k.getText(), this.f.getSelection(), this.e.getSelection());
        if (this.h == -1)
        {
          MessageDialog.openError(getShell(), "", localf.i());
          return;
        }
      }
      catch (Exception localException)
      {
        MessageDialog.openError(getShell(), "", localException.getLocalizedMessage());
        return;
      }
    super.okPressed();
  }

  public int a()
  {
    return this.h;
  }

  public String b()
  {
    return this.b;
  }

  public String c()
  {
    return this.c;
  }

  public String d()
  {
    return this.d;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.g.v
 * JD-Core Version:    0.6.0
 */