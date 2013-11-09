package com.flagleader.builder.dialogs;

import com.flagleader.database.ConnectionFactory;
import com.flagleader.database.ConnectionInfo;
import com.flagleader.manager.d.a;
import com.flagleader.manager.d.b;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class h extends f
{
  private Connection e = null;
  private String f;
  private String g;
  private String h;
  private String i;
  protected Text a;
  protected Text b;
  protected Text c;
  protected Combo d;
  private HashMap j = new HashMap();

  public h()
  {
    super(Display.getCurrent().getActiveShell());
    String[] arrayOfString = a.b("drivers");
    for (int k = 0; k < arrayOfString.length; k++)
      this.j.put(a.a(arrayOfString[k] + ".Driver"), a.a(arrayOfString[k] + ".URL"));
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    c("title.ConnectDialog");
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    Composite localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setLayout(a(2));
    localComposite2.setLayoutData(a(340, 100));
    a(localComposite2, "Driver.ConnectDialog").setLayoutData(b(60));
    this.d = new Combo(localComposite2, 4);
    this.d.setLayoutData(b(225));
    a(this.d);
    b(this.d);
    a(localComposite2, "URL.ConnectDialog").setLayoutData(b(60));
    this.c = a(localComposite2, 2048);
    this.c.setLayoutData(b(240));
    this.d.setText(this.d.getItem(0));
    a(localComposite2, "UserName.ConnectDialog").setLayoutData(b(60));
    this.a = a(localComposite2, 2048);
    this.a.setLayoutData(b(240));
    a(localComposite2, "Password.ConnectDialog").setLayoutData(b(60));
    this.b = a(localComposite2, 67584);
    this.b.setLayoutData(b(240));
    this.b.setEchoChar('*');
    this.d.setText(b.a().k());
    this.c.setText(b.a().o());
    this.a.setText(b.a().n());
    this.b.setText(b.a().m());
    return localComposite2;
  }

  private void a(Combo paramCombo)
  {
    String[] arrayOfString = a.b("drivers");
    for (int k = 0; k < arrayOfString.length; k++)
      paramCombo.add(a.a(arrayOfString[k] + ".Driver"));
  }

  private void b(Combo paramCombo)
  {
    paramCombo.addModifyListener(new i(this, paramCombo));
  }

  protected void okPressed()
  {
    this.i = this.d.getText();
    this.f = this.a.getText();
    this.g = this.b.getText();
    this.h = this.c.getText();
    if (!f())
    {
      MessageDialog.openError(null, b("error.dialog"), b("error.ConnectDialog"));
      return;
    }
    super.okPressed();
  }

  private boolean f()
  {
    try
    {
      if ((this.e != null) && (!this.e.isClosed()))
        this.e.close();
      this.e = ConnectionFactory.getConn(new ConnectionInfo(a(), c(), d(), b(), "", ""));
      b.a().d(a());
      b.a().g(c());
      b.a().f(d());
      b.a().e(b());
      b.a().b();
      return true;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
    }
    catch (SQLException localSQLException)
    {
    }
    return false;
  }

  public String a()
  {
    return this.i;
  }

  public String b()
  {
    return this.g;
  }

  public String c()
  {
    return this.h;
  }

  public String d()
  {
    return this.f;
  }

  public Connection e()
  {
    return this.e;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.h
 * JD-Core Version:    0.6.0
 */