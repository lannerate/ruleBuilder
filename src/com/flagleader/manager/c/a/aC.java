package com.flagleader.manager.c.a;

import com.flagleader.db.Sheet;
import com.flagleader.manager.d.c;
import com.flagleader.manager.r;
import com.flagleader.repository.db.SheetTable;
import java.util.List;

public class aC
  implements com.flagleader.manager.c.c.b
{
  public aC(aw paramaw)
  {
  }

  public boolean a()
  {
    return this.a.f().isSaveValue();
  }

  public boolean a(boolean paramBoolean)
  {
    if (this.a.f().isSaveValue() != paramBoolean)
      if (!paramBoolean)
      {
        if (aw.a(this.a).b().showQuestion(c.b("deletedata.SheetTableProperties")))
        {
          this.a.f().setSheetData(null);
          this.a.f().setSaveValue(paramBoolean);
          this.a.f().getSheetValues().clear();
          this.a.f().updateTree();
          this.a.f().updateViewer();
          return true;
        }
      }
      else
      {
        this.a.f().setSaveValue(paramBoolean);
        try
        {
          Sheet localSheet = this.a.f().getSheetData();
          if (localSheet != null)
            this.a.f().saveValues((Sheet)localSheet.deepClone());
          this.a.f().setModified(true);
          this.a.f().updateTree();
          return true;
        }
        catch (Exception localException)
        {
          aw.a(this.a).b().showError(localException.getLocalizedMessage());
        }
      }
    return true;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.aC
 * JD-Core Version:    0.6.0
 */